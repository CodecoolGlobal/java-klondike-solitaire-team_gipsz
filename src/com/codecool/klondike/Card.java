package com.codecool.klondike;

import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.*;

public class Card extends ImageView {

    private Suit suit;
    private Rank rank;
    private boolean faceDown;

    private Image backFace;
    private Image frontFace;
    private Pile containingPile;
    private DropShadow dropShadow;

    static Image cardBackImage;
    private static final Map<String, Image> cardFaceImages = new HashMap<>();
    public static final int WIDTH = 150;
    public static final int HEIGHT = 215;

    public Card(Suit suit, Rank rank, boolean faceDown) {
        this.suit = suit;
        this.rank = rank;
        this.faceDown = faceDown;
        this.dropShadow = new DropShadow(2, Color.gray(0, 0.75));
        backFace = cardBackImage;
        frontFace = cardFaceImages.get(getShortName());
        setImage(faceDown ? backFace : frontFace);
        setEffect(dropShadow);
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public boolean isFaceDown() {
        return faceDown;
    }

    public String getShortName() {
        return "S" + suit.lowerCaseName() + "R" + rank.lowerCaseRank();
    }

    public DropShadow getDropShadow() {
        return dropShadow;
    }

    public Pile getContainingPile() {
        return containingPile;
    }

    public void setContainingPile(Pile containingPile) {
        this.containingPile = containingPile;
    }

    public void moveToPile(Pile destPile) {
        this.getContainingPile().getCards().remove(this);
        destPile.addCard(this);
    }

    public void flip() {
        faceDown = !faceDown;
        setImage(faceDown ? backFace : frontFace);
    }

    @Override
    public String toString() {
        return "The " + "Rank " + rank.lowerCaseRank() + " of " + "Suit " + suit.lowerCaseName();
    }

    public static boolean isOppositeColor(Card card1, Card card2) {
        if (card1 == null || card2 == null) {
            return false;
        }
        boolean isCard1Red = card1.suit.equals(Suit.HEARTS) | card1.suit.equals(Suit.DIAMONDS);
        boolean isCard2Red = card2.suit.equals(Suit.CLUBS) | card2.suit.equals(Suit.SPADES);

        if (isCard1Red == isCard2Red) return true;
        else return false;
    }

    public static boolean isSameSuit(Card card1, Card card2) {
        return card1.getSuit() == card2.getSuit();
    }

    public static List<Card> createNewDeck() {
        List<Card> result = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                result.add(new Card(suit, rank, true));
            }
        }
        Collections.shuffle(result);
        return result;
    }

    /**
     * For every card it assigns an image by putting it's id as key and image as value in a Map
     */
    public static void loadCardImages(String source) {
        cardBackImage = new Image(source + "card_back.png");
        String suitName = "";
        for (Suit suit : Suit.values()) {
            suitName = suit.lowerCaseName();
            for (Rank rank : Rank.values()) {
                String cardName = suitName + rank.lowerCaseRank();
                String cardId = "S" + suit.lowerCaseName() + "R" + rank.lowerCaseRank();
                String imageFileName = source + cardName + ".png";
                cardFaceImages.put(cardId, new Image(imageFileName));
            }
        }
    }

}
