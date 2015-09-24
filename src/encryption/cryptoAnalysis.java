package encryption;

public class cryptoAnalysis {
	public static int caesarGetKey(String input) {
		int[] freq = new int[26];
		int cur;
		int shift = 0;
		for (int i = 0; i < input.length(); i++) {
			cur = input.charAt(i);
			if ((64 < cur) && (cur < 91)) {
				cur -= 65;
			} else if ((96 < cur) && (cur < 123)) {
				cur -= 97;
			} else {
				continue;
			}
			freq[cur] += 1;
		}
		int bigVal = 0;
		int bigAddr = 0;
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > bigVal) {
				bigVal = freq[i];
				bigAddr = i;
			}
		}

		if (shift < 4) {
			shift += 26;
		}
		shift = bigAddr - 4;
		return shift;
	}
}
