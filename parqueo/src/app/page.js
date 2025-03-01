"use client";
import React, { useState } from "react";
import PlanoParqueo from "./components/PlanoParqueo";
import ResumenReserva from "./components/ResumenReserva";
import SelectorZona from "./components/SelectorZona";
import "./components/style.css";

export default function Home() {
  const [zona, setZona] = useState("Cubierto");
  const [duracion, setDuracion] = useState(1);
  const [espacios, setEspacios] = useState([
    { id: 1, zona: "Cubierto", reservado: false },
    { id: 2, zona: "Cubierto", reservado: false },
    { id: 3, zona: "Descubierto", reservado: false },
    { id: 4, zona: "Descubierto", reservado: false },
    { id: 5, zona: "VIP", reservado: false },
  ]);

  const tarifas = { Cubierto: 2.5, Descubierto: 1.5, VIP: 5.0 };

  // **Función para reservar un espacio**
  const reservarEspacio = (id) => {
    setEspacios((prevEspacios) =>
      prevEspacios.map((espacio) =>
        espacio.id === id ? { ...espacio, reservado: true } : espacio
      )
    );
  };

  const total = tarifas[zona] * duracion;

  return (
    <div className="container">
      <h1 className="title">🚗💨Reserva Estacionamiento</h1>
      <SelectorZona setZona={setZona} />
      <div className="selector-duracion">
        <label>Duración (horas): </label>
        <input
          type="number"
          min="1"
          value={duracion}
          onChange={(e) => setDuracion(Number(e.target.value))}
        />
      </div>

      <PlanoParqueo espacios={espacios.filter((e) => e.zona === zona)} reservarEspacio={reservarEspacio} />

      {/* PASAMOS reservarEspacio como prop */}
      <ResumenReserva 
        total={total} 
        duracion={duracion} 
        zona={zona} 
        espacios={espacios} 
        reservarEspacio={reservarEspacio}
      />
    </div>
  );
}