package es.uji.ei1027.elderly.model;

public class Aviso {

    public Aviso() {
    }

    public void notificarTodoHaIdoBien() {
        System.out.println("===========================================================================");
        System.out.println("Everything was succesfully. A confirmation mail will be sent now.");
        System.out.println("===========================================================================");
    }

    public void notificarCorreoRequest(Request request) {
        System.out.println("===========================================================================");
        System.out.println("E-MAIL");
        String msg = "We confirm to the person with DNI " + request.getDniElderly() + " that the service request " + request.getServiceType() +
                " has been sent succesfully.";
        System.out.println(msg);
        System.out.println("===========================================================================");
    }

    public void notificarCorreoContract(Contract contract) {
        System.out.println("===========================================================================");
        System.out.println("E-MAIL");
        System.out.println("We confirm to the person with CIF " + contract.getCifCompany () + " that the contract has been successfully added");
        System.out.println("The contract includes:");
        System.out.println("- Service Type: " + contract.getServiceType());
        System.out.println("- Date Beginning: " + contract.getDateBeginning());
        System.out.println("- Date ending: " + contract.getDateEnding());
        System.out.println("- Pice unit: " + contract.getPriceUnit());
        System.out.println("- QuantityService: " + contract.getQuantityServices());
        System.out.println("- Units of measure: " + contract.getUnitsOfMeasure());
        System.out.println("===========================================================================");
    }}
