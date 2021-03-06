import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
Первый отчет состоит из таблицы со столбцами: название блюда, количество, стоимость. После таблицы должна быть напечатана полная стоимость заказа.
Второй отчет состоит из таблицы со столбцами: имя сотрудника, заказанные блюда, стоимость его обеда.
    "firstName": "А.",
    "secondName": "Пупкин",
    "menu": {
      "Product{name='Рис отварной с маслом', weight=170, price=16, list_products=[Рис отварной с маслом]}": 1,
      "Product{name='Рулет с изюмом', weight=75, price=15, list_products=[Рулет с изюмом]}": 1,
      "Product{name='Салат изюменка', weight=100, price=35, list_products=[Салат изюменка]}": 1,
      "Product{name='Печень по королевски', weight=150, price=54, list_products=[Печень по королевски]}": 1
 */

public class Orders {

    ArrayList<Product> products = new ArrayList<Product>();
    HashMap<Product, Integer> merger_servings = new HashMap<Product, Integer>();

        public void printPlacedOrder(){
            ArrayList<Worker> workers_list = new Util().getData_Worker();
            for (int workers = 0; workers < workers_list.size(); workers++) {
                for (Map.Entry<Product, Integer> product_portion : workers_list.get(workers).getMenu().entrySet()) {
                    if (chek_Product(product_portion.getKey())) break;
                    else {
                        merger_servings.put(product_portion.getKey(), product_portion.getValue());
                            if (merger_servings.keySet().equals(product_portion.getKey())) {
                                merger_servings.get(product_portion.getValue() + 1);
                            }
                    }
                    products.add(product_portion.getKey());
                }
            }

            for (Map.Entry<Product, Integer> pair : merger_servings.entrySet()){
                System.out.println(pair.getKey() + " " + pair.getValue());
            }
        }


        public  void printReceivedOrder(){

        }
        public boolean chek_Product(Product product){
           for (Product p : products){
               if(p.equals(product)) return true;
           }
            return false;
        }
    }

