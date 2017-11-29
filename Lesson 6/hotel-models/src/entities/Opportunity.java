package entities;

import com.opencsv.bean.CsvBindByName;

public class Opportunity extends Entity {

    @CsvBindByName(column = "name", required = true)
    private String name;
    @CsvBindByName(column = "price", required = true)
    private Integer price;

    public Opportunity(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public Opportunity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Opportunities name is: ").append(this.name).append("   Opportunities price is: ").append(this.price);
        return stringBuilder.toString();
    }

    @Override
    public String getStringForPrintInFile() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" ").append(this.price);
        return sb.toString();
    }
}
