
package  org.example;

import java.util.Set;


public class  ProductManager {

    private Set<String> electronics; 
    private Set<String> discounted;


    public ProductManager(Set<String> electronics, Set<String> discounted){
        this.discounted = discounted;
        this.electronics = electronics;
    }


    public ProductManager(){

    }


    public void addProduct(String category, String product){


    }

    public void removeProduct(String category, String product){
        
    }
}