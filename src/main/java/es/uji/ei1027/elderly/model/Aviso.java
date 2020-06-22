package es.uji.ei1027.elderly.model;

public class Aviso {

    public Aviso() {
    }

    public void notificarTodoHaIdoBien() {
        System.out.println("===========================================================================");
        System.out.println("Todo ha salido correctamente. Le llegará un correo de confirmación en unos instantes");
        System.out.println("===========================================================================");
    }

    public void notificarCorreoRequest(Request request) {
        System.out.println("===========================================================================");
        System.out.println("E-MAIL");
        String msg = "Confirmamos a la persona con DNI " + request.getDniElderly() + " que su solicitud del servicio " + request.getServiceType() +
                " ha sido enviada con exito.";
        System.out.println(msg);
        System.out.println("===========================================================================");
    }

    public void notificarCorreoContract(Contract contract) {
        System.out.println("===========================================================================");
        System.out.println("E-MAIL");
        System.out.println("Confirmamos a la persona con CIF " + contract.getCifCompany() + " que su contrato ha sido añadido con exito");
        System.out.println("El contrato incluye lo siguiente");
        System.out.println("- Serice Type: " + contract.getServiceType());
        System.out.println("- Date Beginning: " + contract.getDateBeginning());
        System.out.println("- Date ending: " + contract.getDateEnding());
        System.out.println("- Pice unit: " + contract.getPriceUnit());
        System.out.println("- QuantityService: " + contract.getQuantityServices());
        System.out.println("- Units of measure: " + contract.getUnitsOfMeasure());
        System.out.println("===========================================================================");
    }

}
