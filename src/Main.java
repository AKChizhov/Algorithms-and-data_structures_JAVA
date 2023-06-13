import java.util.Arrays;

class Main
{
    private static int leftBorder(int i) {
        return (2*i + 1);
    }
    private static int rightBorder(int i) {
        return (2*i + 2);
    }
    private static void swap(int[] inArray, int i, int j) // Реверс
    {
        int temp = inArray[i];
        inArray[i] = inArray[j];
        inArray[j] = temp;
    }

    private static void heaping(int[] MyArray, int i, int size)
    {
        int left = leftBorder(i);
        int right = rightBorder(i);

        int largest = i;

        if (left < size && MyArray[left] > MyArray[i]) {
            largest = left;
        }

        if (right < size && MyArray[right] > MyArray[largest]) {
            largest = right;
        }

        if (largest != i)
        {
            swap(MyArray, i, largest);
            heaping(MyArray, largest, size);
        }
    }

    public static int pop(int[] inArray, int size)
    {
        if (size <= 0) {
            return -1;
        }

        int top = inArray[0];
        inArray[0] = inArray[size-1];
        heaping(inArray, 0, size - 1);

        return top;
    }

    public static void heapsort(int[] inArray)
    {

        int n = inArray.length;
        int i = (n - 2) / 2;
        while (i >= 0) {
            heaping(inArray, i--, n);
        }

        while (n > 0)
        {
            inArray[n - 1] = pop(inArray, n);
            n--;
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+"  ");
        System.out.println();
    }
    public static void main(String[] args)
    {
        int[] myArray = { 6, 4,-90, 7, 1, 88,9, -2 };
        System.out.println("\n\tМассив до сортировки");
        printArray(myArray);
        heapsort(myArray);
        System.out.println("\n\tМассив после сортировки");
        printArray(myArray);
    }
}
