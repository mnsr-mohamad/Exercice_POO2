package bibliotheque.metier;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;

public class Mail {


    private String objet;
    private String message;
    private LocalDate dateEnvoi;
    Scanner sc = new Scanner(System.in);



    public Mail(String objet, String message, LocalDate dateEnvoi) {
        this.objet = objet;
        this.message = message;
        this.dateEnvoi = dateEnvoi;
    }

    public void envoi(Lecteur destinataire) {
        File monFichier = new File(destinataire.getMail()+".txt");

        try(FileWriter out = new FileWriter(monFichier)){
            PrintWriter pw = new PrintWriter(out);
            pw.println("Objet : "+objet);
            pw.println(message+"\n");
            pw.println("La bibliothèque, le " + dateEnvoi+"\n");

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }





    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDateEnvoi() {
        return dateEnvoi;
    }

    public void setDateEnvoi(LocalDate dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "objet='" + objet + '\'' +
                ", message='" + message + '\'' +
                ", dateEnvoi='" + dateEnvoi + '\'' +
                '}';
    }
}
