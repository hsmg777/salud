package com.salud.salud.accion;

import org.openxava.actions.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.salud.salud.modelo.Backup;
import javax.persistence.*;

public class GenerarBackupAction extends ViewBaseAction {

    @Override
    public void execute() throws Exception {
        // Ruta donde se guardarán los backups
        String backupDir = "C:/respaldos/"; // puedes cambiar esta ruta
        new File(backupDir).mkdirs(); // crear si no existe

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String backupFile = "backup_" + timestamp + ".sql";
        String fullPath = backupDir + backupFile;

        // Comando mysqldump
        String comando = "mysqldump -u root -pMamifer1 saluddb -r \"" + fullPath + "\"";

        Process proceso = Runtime.getRuntime().exec(new String[] { "cmd.exe", "/c", comando });
        int status = proceso.waitFor();

        if (status == 0) {
            // Guardar el registro en la base de datos
            EntityManager em = getEntityManager();
            em.getTransaction().begin();

            Backup b = new Backup();
            b.setNombre(backupFile);
            b.setFecha(new Date());
            b.setTamanio(new File(fullPath).length());

            em.persist(b);
            em.getTransaction().commit();

            addMessage("Respaldo generado correctamente: " + backupFile);
        } else {
            addError("Error al generar el respaldo. Verifica el comando.");
        }
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        return emf.createEntityManager();
    }
}
