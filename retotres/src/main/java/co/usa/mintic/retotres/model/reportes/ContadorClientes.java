package co.usa.mintic.retotres.model.reportes;
import co.usa.mintic.retotres.model.client;


public class ContadorClientes {
    private Long total;
    private client client;



    public ContadorClientes(Long total, client client) {

        this.total = total;
        this.client = client;
    }



    public Long getTotal() {
        return total;
    }



    public void setTotal(Long total) {

        this.total = total;

    }



    public client getClient() {

        return client;

    }



    public void setClient(client client) {

        this.client = client;

    }

    

}