package Find_Smallest_Letter_Greater_Than_Target;
public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        if (letters == null || letters.length == 0) throw new IllegalArgumentException("letters can't be null");
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target) {
                return letters[i];
            }
        }
        return letters[0];
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		char[] letters = {'c', 'f', 'j'};
		System.out.println(s.nextGreatestLetter(letters, 'a')); // c
		System.out.println(s.nextGreatestLetter(letters, 'c')); // f
		System.out.println(s.nextGreatestLetter(letters, 'd')); // f
		System.out.println(s.nextGreatestLetter(letters, 'g')); // j
		System.out.println(s.nextGreatestLetter(letters, 'j')); // c
		System.out.println(s.nextGreatestLetter(letters, 'k')); // c
	}
}