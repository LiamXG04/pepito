"use client";
import React from "react";
import Espacio from "./Espacio";

const PlanoParqueo = ({ espacios, reservarEspacio }) => {
  return (
    <div className="grid grid-cols-4 gap-4 p-4">
      {espacios.map((espacio) => (
        <Espacio key={espacio.id} espacio={espacio} reservarEspacio={reservarEspacio} />
      ))}
    </div>
  );
};
export default PlanoParqueo;






