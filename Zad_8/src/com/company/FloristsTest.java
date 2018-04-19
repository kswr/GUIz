package com.company;

public class FloristsTest {

    // definicja metody sumowania wartości kwiatów o podanym kolorze
//    static int valueOf(Box box, String color) {
//        /*<- tu trzeba wpisac kod metody */
//    }

    public static void main(String[] args) {

        // Kwiaciarnia samoobsługowa

        // ustalenie cennika
        PriceList pl = PriceList.getInstance();

        pl.put("róża", 8.0, 5, 7.0);	// róża kosztuje 8 zł/sztuka jeśli klient kupi nie więcej niż 5 sztuk,
        // w innym przypadku kosztuje 7 zł/stukę

        pl.put("bez", 12.0);		// bez kosztuje 12 zł/sztuka niezależnie od ilości

        pl.put("piwonia", 8.0);		// piwonia kosztuje 8 zł/sztuka niezależnie od ilości


        // Przychodzi klient Janek. Ma 200 zł
        Customer janek = new Customer("Janek", 200);

        // Bierze różne kwiaty: 5 róż, 5 piwonii, 3 frezje, 3 bzy
        janek.get(new Rose(5));
        janek.get(new Peony(5));
        janek.get(new Freesia(3));
        janek.get(new Lilac(3));

        // Pewnie je umieścił na wózku sklepowym
        // Zobaczmy co tam ma
        ShoppingCart wozekJanka = janek.getShoppingCart();
        System.out.println("Przed płaceniem " + wozekJanka);

        //todo delete 6 lines
//        Rose rosa = new Rose(5);
//        Rose rosa2 = new Rose(3);
//        Lilac lilac = new Lilac(3);
//        System.out.println(pl.getPrice(rosa));
//        System.out.println(pl.getPrice(rosa2));
//        System.out.println(pl.getPrice(lilac));

        // Teraz za to zapłaci...
        janek.pay(true);	// true = płaci gotówką, bez prowizji

        // Czy przypadkiem przy płaceniu nie okazało się,
        // że w koszu są kwiaty na które nie ustalono jeszcze ceny?
        // W takim razie zostałyby usunięte z wózka i Janek nie płaciłby za nie
        // Również może mu zabraknąć pieniędzy, wtedy też kwiaty są odkładane.
        System.out.println("Po zapłaceniu " + janek.getShoppingCart());

        // Ile Jankowi zostało pieniędzy?
        System.out.println("Jankowi zostało : " + janek.getCash() + " zł");

        // Teraz jakoś zapakuje kwiaty (może do pudełka)
        Box pudelkoJanka = new Box(janek);

//        System.out.println(janek.getShoppingCart());
//
//        for (int i = 0; i< pudelkoJanka.getBox().size();i++){
//            System.out.println(pudelkoJanka.getBox().get(i).getName());
//        }

        janek.pack(pudelkoJanka);

        // Co jest teraz w wózku Janka...
        // (nie powinno już nic być)
        System.out.println("Po zapakowaniu do pudełka " + janek.getShoppingCart());

        // a co w pudełku
        System.out.println(pudelkoJanka);
//
//        // Zobaczmy jaka jest wartość czerwonych kwiatów w pudełku Janka
//        System.out.println("Czerwone kwiaty w pudełku Janka kosztowały: "
//                + valueOf(pudelkoJanka, "czerwony"));
//
//
//        // Teraz przychodzi Stefan
//        // ma tylko 60 zł
//        Customer stefan = new Customer("Stefan", 60);
//
//        // Ale nabrał kwiatów nieco za dużo jak na tę sumę
//        stefan.get(new Rose(6));
//        stefan.get(new Lilac(3));
//
//        // co ma w wózku
//        System.out.println(stefan.getShoppingCart());
//
//        // płaci i pakuje do pudełka
//        stefan.pay(false);	// false = płaci kartą płatniczą, prowizja = 1%
//        Box pudelkoStefana = new Box(stefan);
//        stefan.pack(pudelkoStefana);
//
//        // co ostatecznie udało mu się kupić
//        System.out.println(pudelkoStefana);
//        // ... i ile zostało mu pieniędzy
//        System.out.println("Stefanowi zostało : " + stefan.getCash() + " zł");
    }
}
