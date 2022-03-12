package com.techtorial;

import java.util.Scanner;

public class Products {

    /*
	 * Please add more vending machine features
	 * - Buy a product
	 * - Search for a product
	 * - Get list of products
	 */

    private static String[] products  = new String[] {"Monitor", "Mouse", "Keyboard", "USB cable", "Charger", "Mouse pad"};
    private static int[]    prices    = new int[] {100, 70, 89, 17, 99, 5};
    private static int[]    inventory = new int[] {4, 10, 5, 10, 5, 7};
    public static Scanner scanner = new Scanner(System.in);


    public static String[] getAllProducts() {
        // System.err.println("Product: price");
        for (int j = 0; j < products.length; j++) {
            System.out.println(products[j]);
        }
        return products;
    }
     // 1-> Create a method to just display all product names in vending machine
    // 2->Create a method to display product name, price and inventory at the same time.
    //* 3->We should create a method that takes two parameters for price range and shows
    // all the products in this range. */

    public static String[] getAllPrices() {
        System.err.println("Product: price");
        for (int j = 0; j < products.length; j++) {
            System.out.println(products[j] + ": $" + prices[j]);
        }
        return products;
    }

    public static int getProductPrice(String productName) {
        int productPrice=0;
        for (int i = 0; i < products.length; i++) {
            if (productName.equalsIgnoreCase(products[i])) {
                productPrice=prices[i];
                System.out.println(productPrice+ " is the price for " + productName);
            }

        }

        return productPrice;

    }

    public static void selectProduct(String productName) {
        System.out.println("please choose from available options");
        Scanner ProductName = new Scanner(System.in);
        for(int i=0;i<products.length; i++){
            if(productName.equalsIgnoreCase(products[i])){
                System.out.println("the price for item is "+ prices[i]);
                if(inventory[i]>0){
                    System.out.println("it is available");
                    System.out.println("do you want to buy it?");
                    scanner= new Scanner(System.in);
                    String answer= scanner.next();
                    if(answer.equalsIgnoreCase("yes")){
                System.out.println("Please choose buy a product from the main menu");
                cancel();
           }else{
               cancel();
            }
                }
            }
        }

    	//loop over the product list to find out if it is available in our vending machine
		//if yes find the price (tip: call a specific method)
		//and verify this product is available in inventory
		//ask if customer wants to buy it -> if yes call another method to buy a product
//											-> if no call method to cancel it
    }
    public static void priceRange(int startNum, int endNum){
        for(int i=0; i<prices.length; i++){
            if(prices[i]>=startNum && prices[i]<=endNum){
                System.out.println("You can choose from "+ products[i] +" " + prices[i]);
            }
        }

    }

        public static void buyAProduct() {
        System.out.println("which product would you like to buy");
        String productName= scanner.next();
        // System.out.println("please enter the money");
        int productPrice=0;
        int money=0;
        int inventoryIndex=0;
        for(int i=0; i<products.length; i++) {
            if (productName.equalsIgnoreCase(products[i])) {
                // System.out.println(prices[i]);
                productPrice = prices[i];
                System.out.println("please pay " + productPrice);
                money = scanner.nextInt();
                inventoryIndex=i;
            }
        }
        if(productPrice==money){
            System.out.println("Enjoy your product");
            inventory[inventoryIndex]-=1;
            System.out.println(productName + " is only " + inventory[inventoryIndex] + " left in the stock");
        }else if(money>productPrice){
            int change = money-productPrice;
            System.out.println(change + " is your change. Enjoy your product");
            inventory[inventoryIndex]-=1;
            System.out.println(productName + " is only " + inventory[inventoryIndex] + " left in the stock");
        }else {
            while (money < productPrice) {
                System.out.println(money + " is not enough please give more");
                int moneyAdd = scanner.nextInt();
                money += moneyAdd;
                if (productPrice == money) {
                    System.out.println("Enjoy your product");
                } else if (money > productPrice) {
                    int change = money - productPrice;
                    System.out.println(change + " is your change. Enjoy your product");

                    System.out.println(productName + " is only " + inventory[inventoryIndex] + " left  in the stock");
                }
            }
        }}
        /*
        Apply payment logic.
        Apply give back change logic
        Apply inventory update logic: if someone buys an item, we should decrement number of available items.
         */
        public static void cancel() {
            System.out.println("See you next time");
            return;
        }
    }

