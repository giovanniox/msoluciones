INSERT INTO equipo_entity (equipo, marca, modelo, serie, inventario) VALUES 
('Electrocardiógrafo', 'GE Healthcare', 'MAC 2000', 'ECG12345', 'INV001'),
('Ventilador', 'Philips', 'Respironics V60', 'VTL67890', 'INV002'),
('Monitor', 'Mindray', 'iMEC 10', 'MON34567', 'INV003');
 
INSERT INTO mantenimiento_preventivo_entity (equipo_id, fecha, numeroot, responsable, tipo_de_trabajo) VALUES 
(1, '2024-10-30', 'OT123', 'Juan Pérez', 'preventivo'),
(2, '2024-10-31', 'OT124', 'María González', 'preventivo');
 
INSERT INTO mantenimiento_correctivo_entity (equipo_id, fecha, numeroot, responsable, tipo_de_trabajo) VALUES 
(1, '2024-11-01', 'OT125', 'Carlos Rojas', 'correctivo'),
(3, '2024-11-02', 'OT126', 'Ana López', 'correctivo');
