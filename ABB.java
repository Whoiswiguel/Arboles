//Muñoz Hernandez Miguel Angel
public class ABB{
    private Nodo raiz;

    ABB(){
        this.raiz = null;
    } 

    public boolean esVacio(){
        return (this.raiz == null); 
    }

    public Nodo getRaiz(){
        return this.raiz;
    }

    public void insertarValor(int valor){
        if (this.raiz == null){
            System.out.println("Insertando raiz: " + valor);
            this.raiz = new Nodo();
            this.raiz.dato = valor;
            this.raiz.izquierdo = null;
            this.raiz.derecho = null;
        }
        else insertarNodo(valor, this.raiz);
    }

    public void insertarNodo(int valor, Nodo nodoA){
        if (valor <= nodoA.dato) {
            if (nodoA.izquierdo == null){
                System.out.println("Insertando hijo izquierdo de: "  + nodoA.dato + ": " + valor);
                nodoA.izquierdo =  new Nodo();
                nodoA.izquierdo.dato = valor;
                nodoA.izquierdo.izquierdo = null;
                nodoA.izquierdo.derecho = null;
            }
            else {
                insertarNodo(valor, nodoA.izquierdo);
            }
        }
        else {
            if (valor > nodoA.dato) {
                if (nodoA.derecho == null){
                    System.out.println("Insert hijo derecho de: " + nodoA.dato + ": " + valor);
                    nodoA.derecho =  new Nodo();
                    nodoA.derecho.dato = valor;
                    nodoA.derecho.izquierdo = null;
                    nodoA.derecho.derecho = null;
                }
                else {
                    insertarNodo(valor, nodoA.derecho);
                }
            }
        }
    }

    public void arbolHorizontal(int nivel, Nodo nodoA){
        if(nodoA == null){
            return; 
        }
        else{

            arbolHorizontal(nivel + 1, nodoA.derecho);

            for(int i=0;i<nivel;i++){
                System.out.print("   ");
            }

            System.out.println("["+ nodoA.dato + "]");
            arbolHorizontal(nivel + 1,nodoA.izquierdo);
        }
    }

    public void inorden(Nodo nodoA){
        if(nodoA==null)
            return; 
        inorden(nodoA.izquierdo);
        System.out.print(nodoA.dato + " - ");
        inorden(nodoA.derecho);
    }

    public void preorden(Nodo nodoA){
        if(nodoA==null)
            return; 
        System.out.print(nodoA.dato + " - ");
        preorden(nodoA.izquierdo);
        preorden(nodoA.derecho);
    }

    public void postorden(Nodo nodoA){
        if(nodoA==null)
            return; 
        postorden(nodoA.izquierdo);
        postorden(nodoA.derecho);
        System.out.print(nodoA.dato + " - ");
    }

    public boolean busqueda(int x, Nodo nodoA){
        if (nodoA==null)
            return false;
        else if(x<nodoA.dato)
            return busqueda(x,nodoA.izquierdo);
        else if(x>nodoA.dato)
            return busqueda(x,nodoA.derecho);
        else 
            return true; 
    }

    public void CortarArbol(Nodo nodoA)
    {
        if(nodoA==null)
            return;

        //Se elimina el subnodoRef izquierdo
        CortarArbol(nodoA.izquierdo);
        //Se elimina el subnodoRef derecho
        CortarArbol(nodoA.derecho);
        //Se elimina el nodo actual
        nodoA = null;
    }

    public Nodo buscaMayor(Nodo nodoA) {
        if (nodoA == null) {
            return null;
        } else if (nodoA.derecho == null) {
            return nodoA;
        } else {
            return buscaMayor(nodoA.derecho);
        }
    }

    public void eliminarPredecesor(int x, Nodo nodoA) {
        if (nodoA == null) {
            return;
        } else if (x < nodoA.dato) {
            eliminarPredecesor(x, nodoA.izquierdo);
        } else if (x > nodoA.dato) {
            eliminarPredecesor(x, nodoA.derecho);
        } else if (nodoA.izquierdo != null && nodoA.derecho != null) {
            Nodo mayor = buscaMayor(nodoA.izquierdo);
            nodoA.dato = mayor.dato;
            eliminarPredecesor(mayor.dato, nodoA.izquierdo);
        } else {
            if (nodoA.izquierdo == null) {
                nodoA = nodoA.derecho;
            } else if (nodoA.derecho == null) {
                nodoA = nodoA.izquierdo;
            }
        }
    }
}