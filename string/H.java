package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class H {
	static String solution(String[] logs) {
		Map<String, ArrayList<String>> dict = new HashMap<>();
		String curr = "";
		for (String s : logs) {
			if (s.startsWith("switch")) {
				String key = s.substring(7);
				curr = key;
				if (!dict.containsKey(key)) {
					ArrayList<String> value = new ArrayList<>();
					dict.put(key, value);
				}
			} else {
				String v = s.substring(5);
				if (!dict.get(curr).contains(v)) dict.get(curr).add(v);
			}
		}
		int max = 0;
		for (ArrayList<String> a : dict.values()) {
			max = Math.max(max, a.size());
		}
		String ans = "";
		for (Map.Entry<String, ArrayList<String>> e : dict.entrySet()) {
			if (e.getValue().size() == max) ans = e.getKey();
		}
		return ans;
	}
	public static void main(String[] args) {
		String[] log = {"switch 22", "load 1", "switch 11", "load 1", "load 1", "load 1", "switch 22", "load 2"};
		System.out.println(solution(log));

	}
}