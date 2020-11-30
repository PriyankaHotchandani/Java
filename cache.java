import java.util.Scanner;
import java.util.Random;

public class cache {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);

        System.out.print("\nEnter size of cache: "); 
        int cacheSize = s1.nextInt ();

        System.out.print("Enter size of main memory: "); 
        int memsize = s1.nextInt ();

        System.out.print("Enter words per block: ");
        int words = s1.nextInt ();

        int totalLines = cacheSize/words; 
        int c=0;

        while (c==0) {
            int[] cache = new int[cacheSize];
            System.out.print("\n1. Direct Mapping\n2. Associative Mapping\n3. Two way set associative mapping\n4. Exit\nEnter your choice: ");
            int choice = s1.nextInt();
            int hit = 0;
            
            if (choice==4) {
                c++;
                break;
            }
            System.out.print("\nEnter total number of blocks to be added to cache: ");
            int totalBlocks = s1.nextInt();
            for (int i = 0; i < totalBlocks; i++) {
                System.out.print("\nCache: \n");
                for (int k = 0; k < totalLines; k++) {
                    System.out.println(k + " -> " + cache[k]);
                }

                System.out.print("\nEnter the block number needed: ");
                int blockNumber = s1.nextInt();
                while (blockNumber >= (memsize / words) || blockNumber < 0) {
                    System.out.println("You enter: " + blockNumber + "\nMain Memory blocks: "+ (memsize / words - 1) + "\nTry again\n");
                    System.out.print("Enter the word number needed: ");
                    blockNumber = s1.nextInt();
                }

                if (blockNumber == 0) {
                    hit--;
                }

                int isFound = 0;
                Random random = new Random();
                switch (choice) {
                    case 1:
                        int lineNumber = Mapping.DirectMapping(blockNumber, totalLines);
                        if (cache[lineNumber] == blockNumber) {
                            hit++;
                        } else {
                            System.out.println("Overriding " + cache[lineNumber] + " with " + blockNumber);
                            cache[lineNumber] = blockNumber;
                        }
                        break;

                    case 2:
                        lineNumber = 0;
                        for (int j = 0; j < totalLines; j++) {
                            if (cache[j] == blockNumber) {
                                hit++;
                                isFound++;
                                break;
                            }
                        }
                        lineNumber = random.nextInt(totalLines);
                        if (isFound == 0) {
                            System.out.println("Overriding " + cache[lineNumber] + " with " + blockNumber);
                            cache[lineNumber] = blockNumber;
                        }
                        break;

                    case 3:
                        int wayNumber = Mapping.SetAssociative(blockNumber, 2);
                        wayNumber *= 2; 
                        for (int j = 0; j < totalLines / 2; j++) {
                            if (cache[wayNumber + j] == blockNumber) {
                                hit++;
                                isFound = 1;
                                break;
                            }
                        }
                        if (isFound == 0) {
                            int offset = random.nextInt(3);
                            lineNumber = wayNumber + offset;
                            System.out.println("Overriding " + cache[lineNumber] + " with " + blockNumber);
                            cache[lineNumber] = blockNumber;
                        }
                        break;

                }
            }
            System.out.print("\nFinal Cache: \n");
            for (int i = 0; i < totalLines; i++) {
                System.out.println(i + " -> " + cache[i]);
            }
            System.out.println("\nTotal hits: " + hit);
            System.out.println("\n\n\n");
        }

    }
}

class Mapping {
    static int DirectMapping(int blockNumber, int totalLines) {
        return blockNumber % totalLines;
    }

    static int SetAssociative(int blockNumber, int setSize) {
        return blockNumber % setSize;
    }
}