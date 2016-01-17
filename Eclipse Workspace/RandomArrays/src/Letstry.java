import java.util.Random;

public class Letstry {

	public static void main(String[] args) {
		int[] array = {1, 2, 3};
		ShuffleArray(array);
		System.out.println("" + array[0] + array[1] + array[2]);

	}

	private static void ShuffleArray(int[] array)
	{
	    int index;
	    Random random = new Random();
	    for (int i = array.length - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);
	        if (index != i)
	        {
	            array[index] ^= array[i];
	            array[i] ^= array[index];
	            array[index] ^= array[i];
	        }
	    }
	}
	
}
