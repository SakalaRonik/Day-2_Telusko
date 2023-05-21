import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Product getProduct(String name){
        for(Product p : products){
            if(p.getName().equals(name))
                return p;
        }

        return null;
    }

//    public List<Product> getProductWithText(String text) {
//        String str = text.toLowerCase();
//        List<Product> prods = new ArrayList<>();
//
//        for(Product p : products){
//            String name = p.getName().toLowerCase();
//            String type = p.getType().toLowerCase();
//            String place = p.getPlace().toLowerCase();
//            if(name.contains(str) || type.contains(str) || place.contains(str))
//                prods.add(p);
//        }
//        return prods;
//
//    }
    //Using Stream API
public List<Product> getProductWithText(String text) {
    String str = text.toLowerCase();

    return products.stream()
            .filter(p -> p.getName().toLowerCase().contains(str)
                    || p.getType().toLowerCase().contains(str)
                    || p.getPlace().toLowerCase().contains(str))
            .collect(Collectors.toList());
}


//    public List<Product> getProductByPlace(String text) {
//        String str = text.toLowerCase();
//        List<Product> prods = new ArrayList<>();
//
//        for(Product p : products){
//            String name = p.getName().toLowerCase();
//            String type = p.getType().toLowerCase();
//            String place = p.getPlace().toLowerCase();
//            if(name.contains(str) || type.contains(str) || place.contains(str))
//                prods.add(p);
//        }
//        return prods;
//
//    }
public List<Product> getProductByPlace(String text) {
    String str = text.toLowerCase();

    return products.stream()
            .filter(p -> {
                String name = p.getName().toLowerCase();
                String type = p.getType().toLowerCase();
                String place = p.getPlace().toLowerCase();
                return name.contains(str) || type.contains(str) || place.contains(str);
            })
            .collect(Collectors.toList());
}


//    public List<Product> getProductOutOfWarranty() {
//        List<Product> prods = new ArrayList<>();
//        for(Product p : products){
//            int warranty = p.getWarranty();
//            if(warranty<2023)
//                prods.add(p);
//        }
//        return prods;
//    }

    public List<Product> getProductOutOfWarranty() {
        return products.stream()
                .filter(p -> p.getWarranty() < 2023)
                .collect(Collectors.toList());
    }

}
