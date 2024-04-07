import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class List {
    Node head;

    List() {
        this.head = null;
    }

    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
}

public class Main {
    static boolean hasThree(int num) {
        while (num > 0) {
            int digit = num % 10;
            if (digit == 3) {
                return true;
            }
            num /= 10;
        }
        return false;
    }

    static int ListSum(List list) {
        int sum = 0;
        Node current = list.head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }

    static List PrimeNums(int n) {
        List primesList = new List();
        List ThreeList = new List();

        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);

        for (int p = 2; p * p <= n; p++) {
            if (primes[p]) {
                for (int i = p * p; i <= n; i += p) {
                    primes[i] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                primesList.insert(i);
                if (hasThree(i)) {
                   ThreeList.insert(i);
                }
            }
        }
        System.out.println("Prime numbers from 0 to " + n + ": " + ListSum(primesList));
        return ThreeList;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        int n = scanner.nextInt();

        List primeNums = PrimeNums(n);
        System.out.println("Sum of prime numbers with digit 3: " + ListSum(primeNums));
    }
}
