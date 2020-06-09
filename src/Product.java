import java.util.SplittableRandom;

public class Product {
    private String batchNumber;
    private String productName;
    private String  productCategory;
    private ExpiryDate expiryDate;
    private float wholesaleMRP;
    private float retailMRP;
    private ProductSeller productSeller;
    private int productId;
    public static final String[] headerTitles ={
            "PRODUCT_ID",
            "BATCH_NUMBER",
            "PRODUCT_NAME",
            "PRODUCT_CATEGORY",
            "EXPIRY_DATE",
            "WHOLESALE_MRP",
            "RETAIL_MRP",
            "PRODUCT_SELLER"
    };
    public final static int fieldCount = 8;

    public Product(){
        this.setProductId(new NumberOfRecords().getNumberOfRecords()+1);
        this.setProductName("xxxxxx");
        this.setBatchNumber("xxxxxx");
        this.setProductCategory("xxxxxxx");
        this.setExpiryDate(new ExpiryDate());
        this.setWholesaleMRP((float) 0.0);
        this.setRetailMRP((float) 0.0);
        this.setProductSeller(new ProductSeller());

    }

    public String[] getHeaderOfFile(){
       return headerTitles;
    }

    public void setDetail(String[] info){
        System.out.println("\nset detail:\n");
        this.productId = Integer.parseInt(info[7]);
        this.batchNumber =  info[0];
        this.productName = info[1];
        this.productCategory = info[2];

        String[] expDate = info[3].split(",",2);
        ExpiryDate expiryDate = new ExpiryDate();
        expiryDate.setExpiryMonth(expDate[0]);
        expiryDate.setExpiryYear(Integer.parseInt(expDate[1]));
        this.expiryDate = expiryDate;

        this.wholesaleMRP = Float.parseFloat(info[4]);
        this.retailMRP = Float.parseFloat(info[5]);

        String[] prodSeller = info[6].split(",",ProductSeller.productSellerFieldCount);
        ProductSeller productSeller = new ProductSeller();
        productSeller.setSellerName(prodSeller[0]);
//        productSeller.setGSTNumber(prodSeller[1]);
//        productSeller.setSellerLocation(prodSeller[2]);
//        productSeller.setContactNumber(prodSeller[3]);
//        productSeller.setAlternateContactNumber(prodSeller[4]);
//        productSeller.setEmailAddress(prodSeller[5]);
        this.productSeller = productSeller;


    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductId(){return productId;}
    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setExpiryDate(ExpiryDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public ExpiryDate getExpiryDate() {
        return expiryDate;
    }

    public void setWholesaleMRP(float wholesaleMRP) {
        this.wholesaleMRP = wholesaleMRP;
    }

    public float getWholesaleMRP() {
        return wholesaleMRP;
    }

    public void setRetailMRP(float retailMRP) {
        this.retailMRP = retailMRP;
    }

    public float getRetailMRP() {
        return retailMRP;
    }

    public ProductSeller getProductSeller() {
        return productSeller;
    }

    public void setProductSeller(ProductSeller productSeller) {
        this.productSeller = productSeller;
    }
}
