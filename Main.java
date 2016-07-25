package com.company;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        return;
    }

    /*
    Please implement this method to
    take cents as a parameter
    and return an equal amount in dollars and coins using the minimum number of
    coins possible.
    For example: 164 cents = 1 dollar, 2 quarters, 1 dime and 4 cents.
    Return null if the parameter is negative.
    */
    public static Change getCorrectChange(int cents) {
        if ((cents == 0) || (cents < 0))
            return null;

        ConvertChange ConvertChangeObj = new ConvertChange();
        ConvertChangeObj.ChangeValue = cents;
        int CurrDollar = ConvertChangeObj.Fract(ConvertChangeObj, ConvertChangeObj.DollarVal);
        int Curr_25_Cents = ConvertChangeObj.Fract(ConvertChangeObj, ConvertChangeObj.QuartersVal);
        int CurrDimes = ConvertChangeObj.Fract(ConvertChangeObj, ConvertChangeObj.DimesVal);
        int Curr_5_Cents = ConvertChangeObj.Fract(ConvertChangeObj, ConvertChangeObj.NickelsVal);
        int Curr_Cents = ConvertChangeObj.ChangeValue;
        ConvertChangeObj = null;
        Change CurrChange = new Change(CurrDollar, Curr_25_Cents, CurrDimes, Curr_5_Cents, Curr_Cents);
        return CurrChange;
    }

    public static class ConvertChange{
        public static int ChangeValue;

        public static final int DollarVal = 100;
        public static final int QuartersVal = 25;
        public static final int DimesVal = 10;
        public static final int NickelsVal = 5;

        public static int Fract(ConvertChange Value, int ChangeType){
            int intValue = Value.ChangeValue;
            Value.ChangeValue = intValue % ChangeType;
            return intValue / ChangeType;
        };
    }

    // Please do not change this class
    static class Change {
        private final int _dollars;
        private final int _quarters; //25 cents
        private final int _dimes; // 10 cents
        private final int _nickels; // 5 cents
        private final int _cents; // 1 cent


        public Change(int dollars, int quarters, int dimes, int nickels, int cents) {
            _dollars = dollars;
            _quarters = quarters;
            _dimes = dimes;
            _nickels = nickels;
            _cents = cents;
        }


        public int getDollars() {
            return _dollars;
        }


        public int getQuarters() {
            return _quarters;
        }


        public int getDimes() {
            return _dimes;
        }


        public int getNickels() {
            return _nickels;
        }


        public int getCents() {
            return _cents;
        }
    }

    /*
    Please implement this method to
    return the sum of the two largest numbers in a given array.
    */
    public static int sumOfTwoLargestElements(int[] a) {
        if ((a == null) || (a.length < 0))
            return 0;
        int[] New_a = new int[a.length];
        New_a = a;
        Arrays.sort(New_a);
        int Summ = New_a[New_a.length - 1] + New_a[New_a.length - 2];
        New_a = null;
        return Summ;
    }

    // Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }

    /*
    Please implement this method to
    return the average of all node values (Node.getValue()) in the tree.
    */
    public static double getAverage(Node root) {
        if (root == null)
            return 0;
        NodeClass NewNodeObj = new NodeClass();
        return NewNodeObj.getAverage(root);
    }

    public static class NodeClass implements Node {
        private List<Node> children = new ArrayList<Node>();
        private int value;

        @Override
        public int getValue() {
            return value;
        }

        @Override
        public List<Node> getChildren() {
            return children;
        }

        public static double getAverage(Node root) {
            if (root == null)
                return 0;

            Counter c = new Counter();
            calculateAverage(root, c);

            return c.sum / c.count;
        }

        public static class Counter {
            public int sum;
            public int count;
        }

        private static void calculateAverage(Node root, Counter counter) {
            if (root == null)
                return;

            counter.sum += root.getValue();
            counter.count++;

            for (Node child : root.getChildren())
                calculateAverage(child, counter);
        }
    }

    /*
    A set of stairs has N steps.
    You can jump either 1 or 2 steps at a time.
    For example, if the stairs is N=4 steps, you can reach the end in 5 possible ways:
    1-1-1-1, or 1-2-1 or 1-1-2 or 2-1-1 or 2-2
    Please implement this method to
    return the count of the different ways to reach the end of the stairs with N steps.
    */
    public static int countWaysToJump(int N) {
        if (N <= 0)
            return 0;
        return Step(N + 1);
    }

    public static int Step(int n)
    {
        if (n <= 1)
            return n;
        return Step(n-1) + Step(n-2);
    }
}
