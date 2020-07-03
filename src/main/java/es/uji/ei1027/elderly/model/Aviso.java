package es.uji.ei1027.elderly.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Aviso {

    public Aviso() {
    }

    public void notificarTodoHaIdoBien() {
        System.out.println("===========================================================================");
        System.out.println("Everything was succesfully. A confirmation mail will be sent now.");
        System.out.println("===========================================================================");
    }

    public void notificarCorreoRequest(Request request) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println("===========================================================================");
        System.out.println("E-MAIL");
        String msg = "We confirm to the person with DNI " + request.getDniElderly() + " that the service request " + request.getServiceType() + " has been sent succesfully.";
        System.out.println(msg);
        System.out.println("- Creation date: " + formatter.format(calendar.getTime()));
        System.out.println("- Request state: Pending");
        System.out.println("We will notify you when we accept or reject your request");
        System.out.println("===========================================================================");
    }

    public void notificacionCorreoRequestAceptada() {

    }

    public void notificarCorreoContract(Contract contract) {
        System.out.println("===========================================================================");
        System.out.println("E-MAIL");
        System.out.println("We confirm to the company with CIF " + contract.getCifCompany () + " that the contract has been successfully added");
        System.out.println("The contract includes:");
        System.out.println("- Service Type: " + contract.getServiceType());
        System.out.println("- Date Beginning: " + contract.getDateBeginning());
        System.out.println("- Date ending: " + contract.getDateEnding());
        System.out.println("- Pice unit: " + contract.getPriceUnit());
        System.out.println("- QuantityService: " + contract.getQuantityServices());
        System.out.println("- Units of measure: " + contract.getUnitsOfMeasure());
        System.out.println("===========================================================================");
    }

}
