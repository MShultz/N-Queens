
public class Queens {
	private int[] board;
	private boolean solutionPrinted;
	private int numSteps;

	public void nQueens(int maxBoardSize) {
		for (int currentBoardSize = 1; currentBoardSize <= maxBoardSize; ++currentBoardSize) {
			System.out.println("One Solution for a " + currentBoardSize + "X" + currentBoardSize + " Board");
			resetVariables(currentBoardSize);
			placeQueen(0);
			if (!solutionPrinted) {
				System.out.println("No Solutions Found");
			}
			System.out.print("\n");
		}
	}

	private void placeQueen(int currentIndex) {
		if (!solutionPrinted) {
			if (currentIndex == board.length) {
				print();
				solutionPrinted = true;
			} else {
				for (int value = 0; value < board.length; ++value) {
					++numSteps;
					board[currentIndex] = value;
					if (isValidPlacement(currentIndex))
						placeQueen(currentIndex + 1);
				}
			}
		}
	}

	private boolean isValidPlacement(int placementLocation) {
		for (int i = 0; i < placementLocation; ++i) {
			int locationDifference = placementLocation - i;
			if (board[i] == board[placementLocation] || (board[i] - board[placementLocation]) == locationDifference
					|| (board[placementLocation] - board[i]) == locationDifference)
				return false;
		}
		return true;
	}

	private void print() {
		for (int row = 0; row < board.length; ++row) {
			for (int col = 0; col < board.length; ++col) {
				if (board[row] == col)
					System.out.print("|Q|");
				else
					System.out.print("| |");
			}
			System.out.print("\n");
		}
		System.out.println("Number of Steps: " + numSteps);
	}

	private void resetVariables(int currentBoardSize) {
		solutionPrinted = false;
		numSteps = 0;
		board = new int[currentBoardSize];
	}
}
