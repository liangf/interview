

public class find_zero {
	public static boolean haveZero(int[] nums, int index) {

		boolean[] visited = new boolean[nums.length];
		return help(nums, index, visited);
	}

	public static boolean help(int[] nums, int index, boolean[] visited) {
		if (index<0 || index>=nums.length) {
			return false;
		}
		if (visited[index]) {
			return false;
		}

		if (nums[index] == 0) {
			return true;
		}
		visited[index] = true;

		int a = index + nums[index];
		int b = index - nums[index];

		return help(nums, a, visited) || help(nums, b, visited);
	}

	public static void main(String[] args) {
		int[] nums = {2, 4, 1, 2, 0, 1};
		System.out.println(haveZero(nums, 1));
	}
}