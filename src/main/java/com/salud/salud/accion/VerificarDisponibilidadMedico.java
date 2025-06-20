package com.salud.salud.accion;

import org.openxava.actions.ViewBaseAction;
import com.salud.salud.modelo.Cita;
import com.salud.salud.modelo.Medico;

public class VerificarDisponibilidadMedico extends ViewBaseAction {

    @Override
    public void execute() throws Exception {
        Medico medico = (Medico) getView().getEntity();

        Cita cita = new Cita();
        cita.setFecha(java.time.LocalDate.now().plusDays(1));
        cita.setMedico(medico);

        boolean disponible = medico.estaDisponibleParaCita(cita);

        addMessage(disponible
            ? "El médico está disponible para la cita."
            : "El médico NO está disponible para la cita.");
    }

}
