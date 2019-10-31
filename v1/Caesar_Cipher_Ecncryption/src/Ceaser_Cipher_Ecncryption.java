/* Date: 31-10-2019
 * Mojahedul Islam
 * Course: Cryptography Lab
 * Task name: Applying Caesar Cipher to a line of texts
 */



import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;



public class Ceaser_Cipher_Ecncryption {

	
static int increment_Value = 3;
	
	public static void main(String[] args) throws IOException,FileNotFoundException
	{
		
		File file = new File("Caesar_Cipher_Input.txt"); 
		  
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		
		String encoded_Output = "";
		String a = br.readLine();
		System.out.println("Ceaser Cipher Encryption::\n");
		System.out.println("User input: " + a);
		
		String[] input = a.split("");
		
//		for(String s: input)
//		{
//			System.out.print(s);	
//		}
//		
		System.out.println("\n\n\tEncoder");
		System.out.println("---------------------");
		System.out.println("Input: " + a);
		System.out.print("Encoded Output: ");

		for(int i = 0; i < input.length; i++)
		{
			char ch = a.charAt(i);
			
			if(ch >= 'a' && ch <= 'z' )
			{
				ch = (char) (ch + 3);
				
				int it = (int) ch;
				
				if(it >= 97 && it <= 122)
				{
					System.out.print(" " + ch);
					encoded_Output = encoded_Output + ch;
				}
				
				else if( it > 122)
				{
					int mod_Value = (it % 96) - 27;
					ch = (char) ('a' + mod_Value);
					
					System.out.print(" " + ch);
					encoded_Output = encoded_Output + ch;
				}
				
				
//				System.out.print(" " + it);
//				System.out.println();
//				
//				System.out.println();
				
			} //End of if(ch >= 'a' && ch <= 'z' );
			
			
			else if( ch >= 'A' && ch <= 'Z' )
			{
				if(ch >= 'A' && ch <= 'Z' )
				{
					ch = (char) (ch + 3);
					
					int it = (int) ch;
					
					if(it >= 65 && it <= 90)
					{
						System.out.print(" " + ch);
						encoded_Output = encoded_Output + ch;
					}
					
					else if( it > 90)
					{
						int mod_Value = (it % 64) - 27;
						ch = (char) ('A' + mod_Value);
						
						System.out.print(" " + ch);
						encoded_Output = encoded_Output + ch;
					}
					
					
//					System.out.print(" " + it);
//					System.out.println();
//					
//					System.out.println();
					
				} //End of if(ch >= 'a' && ch <= 'z' );
			
			} //End of else if();
			
			
			else
			{
				System.out.print(" " + ch);
				encoded_Output = encoded_Output + ch;
			}
		
		} //End of for();
		
		
		Decoder(encoded_Output);
		
//		String decoded_Output = Decoder(encoded_Output);
		
	} //End of Main();
	
	
	
	
	
	//------------------------------
	static void Decoder(String input)
	{
		System.out.println();
		System.out.println("\n\n\tDecoder");
		System.out.println("---------------------");
		System.out.println("Input: " + input);
		System.out.print("Decoded Output: ");
		
		for(int i = 0; i < input.length(); i++)
		{
			char ch = input.charAt(i);
			int int_Value = 0;
			
			
			//Checking it if it is in a-z
			//a = 97, z = 122
			if( ch >= 'a' && ch <= 'z' )
			{
				int_Value = (int) (ch - increment_Value);
				
//				System.out.println(int_Value);
				
				if( int_Value < 97 )
				{
					int temp = 97 - int_Value;
					ch = (char) ('z' - temp +1);
					System.out.print(" " + ch);
				}
				else
				{
					ch = (char) (ch - increment_Value);
					System.out.print(" " + ch);
				}
				
			} //End of if(ch >= 'a' && ch <= 'z' );
			
			
			
			
			//Checking either it is in A-Z
			//A = 65, Z = 97
			else if( ch >= 'A' && ch <= 'Z' )
			{
				int_Value = (int) (ch - increment_Value);
				
				if(int_Value < 65)
				{
					int temp = 65 - int_Value;
					ch = (char) ('Z' - temp +1);
					System.out.print(" " + ch);
				}
				else
				{
					ch = (char) (ch - increment_Value);
					System.out.print(" " + ch);
				}
				
			} //End of else if( ch >= 'A' && ch <= 'Z' );
			
			
			
			
			//For any characrters other than a-z & A-Z
			//i.e = {}, 123..., &*
			else
			{
				System.out.print(" " + ch);
			}
			
			
		} //End of for() condition;
		
	} //End of method static void Decoder(String input);
	
	
	
} //End of Public class;
