"use client";
import React from "react";
import "./style.css";

const SelectorZona = ({ setZona }) => {
  return (
    <div className="mb-4">
      <select className="border p-2 rounded-lg mr-2" onChange={(e) => setZona(e.target.value)}>
        <option value="Cubierto">Cubierto</option>
        <option value="Descubierto">Descubierto</option>
        <option value="VIP">VIP</option>
      </select>
      <button className="bg-blue-500 text-white px-4 py-2 rounded">Seleccionar Zona</button>
    </div>
  );
};
export default SelectorZona;

