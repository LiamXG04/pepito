import React, { useState } from "react";

const ResumenReserva = ({ espacios = [] }) => {
  // Estado para los espacios disponibles
  const [disponibles, setDisponibles] = useState({
    Cubierto: espacios.filter((e) => e.zona === "Cubierto" && !e.reservado).length,
    Descubierto: espacios.filter((e) => e.zona === "Descubierto" && !e.reservado).length,
    VIP: espacios.filter((e) => e.zona === "VIP" && !e.reservado).length,
  });

  // Estado para la duración de la reserva
  const [horas, setHoras] = useState(1);

  // Estado para la cantidad de espacios reservados por zona
  const [reservas, setReservas] = useState({ Cubierto: 0, Descubierto: 0, VIP: 0 });

  const precios = { Cubierto: 2, Descubierto: 1.5, VIP: 3 };

  // Función para reservar un espacio en una zona
  const reservarEspacio = (zona) => {
    if (disponibles[zona] > 0) {
      setDisponibles((prev) => ({ ...prev, [zona]: prev[zona] - 1 }));
      setReservas((prev) => ({ ...prev, [zona]: prev[zona] + 1 }));
    }
  };

  // Función para calcular el costo total
  const calcularCosto = () => {
    return (
      horas *
      (precios.Cubierto * reservas.Cubierto +
        precios.Descubierto * reservas.Descubierto +
        precios.VIP * reservas.VIP)
    ).toFixed(2);
  };

  return (
    <div className="resumen-container">
      <h2>📊 Resumen de Disponibilidad</h2>
      <p>🅿️ <strong>Cubierto:</strong> {disponibles.Cubierto} disponibles</p>
      <button onClick={() => reservarEspacio("Cubierto")}>🅿️ Reservar Cubierto</button>

      <p>🌞 <strong>Descubierto:</strong> {disponibles.Descubierto} disponibles</p>
      <button onClick={() => reservarEspacio("Descubierto")}>🌞 Reservar Descubierto</button>

      <p>🎖️ <strong>VIP:</strong> {disponibles.VIP} disponibles</p>
      <button onClick={() => reservarEspacio("VIP")}>🎖️ Reservar VIP</button>

      {/* Selector de horas */}
      <div className="horas-container">
        <label htmlFor="horas">⏳ Duración (horas):</label>
        <input
          id="horas"
          type="number"
          min="1"
          value={horas}
          onChange={(e) => setHoras(Number(e.target.value))}
        />
      </div>

      {/* Costo total de la reserva */}
      <p className="costo-total">
        💰 Costo total: <strong>${calcularCosto()}</strong>
      </p>
    </div>
  );
};
export default ResumenReserva;

