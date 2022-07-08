package maps.maplista;

public class Noh {
    private Noh prox;
    private Noh ant;
    private Object info;

    public Noh(Object info){
        this.prox = null;
        this.ant = null;
        this.info = info;
    }

    public Noh getProx(){
        return prox;
    }

    public void setProx(Noh prox){
        this.prox = prox;
    }

    public Noh getAnt(){
        return ant;
    }

    public void setAnt(Noh ant){
        this.ant = ant;
    }

    public Object getInfo(){
        return info;
    }
}
