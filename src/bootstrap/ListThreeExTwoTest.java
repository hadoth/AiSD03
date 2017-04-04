package bootstrap;

import utils.FifoBuffer;

/**
 * Created by Karol Pokomeda on 2017-03-29.
 */
public class ListThreeExTwoTest {
    public static void main(String[] args){
        int queueSize = 2;

        FifoBuffer<String> inputQueue = new FifoBuffer<>(queueSize);
        String[] names = {"Jamel","Rod","Les","Jonathan","Raymon","Noel","Fredrick","Long","Gerald","David","Wally","Reggie","Colton","Alton","Teddy","Kristofer","Jamison","Antone","Enrique","Lonnie","Saul","Marquis","Curt","Angelo","Damien","Olen","Chase","Emanuel","Bradley","Christoper","Sterling","Millard","Amado","Jerome","Elmer","Mitchel","Eldridge","Rodrick","Frederick","Dudley","Terrance","Minh","Ed","Milford","Eddie","Dorian","Ollie","Nelson","Adolfo","Fermin"};

        int i = 0;
        while(i < names.length) {
            int rndValue = i+(int)(Math.random()*(names.length-i));
            int rndDecision = 3;
            if (!inputQueue.isEmpty() && !inputQueue.isFull()) rndDecision = (int)(Math.random()*2);
            if (inputQueue.isEmpty() || rndDecision ==0){
                inputQueue.push(names[rndValue]);
                System.out.println("(" + inputQueue.size() +")\t" + "Enqueue " + names[rndValue]);
                names[rndValue] = names[i];
                i++;
            }
            if (inputQueue.isFull() || rndDecision ==1){
                String result = inputQueue.pop();
                System.out.println("(" + inputQueue.size() +")\t" + "\t\t\t\t\tDequeue " + result);
            }
        }
        while(!inputQueue.isEmpty()){
            String result = inputQueue.pop();
            System.out.println("(" + inputQueue.size() +")\t" + "\t\t\t\t\tDequeue " + result);
        }
    }
}
