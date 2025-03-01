import React from "react";

const Espacio = ({ espacio, reservarEspacio }) => {
  const getZonaClass = (zona) => {
    if (espacio.reservado) return "espacio reservado";
    if (zona === "Cubierto") return "espacio espacio-cubierto";
    if (zona === "Descubierto") return "espacio espacio-descubierto";
    if (zona === "VIP") return "espacio espacio-vip";
  };

  return (
    <div className={getZonaClass(espacio.zona)} onClick={() => reservarEspacio(espacio.id)}>
      {espacio.reservado ? "Reservado" : "Disponible"}
    </div>
  );
}
export default Espacio;

