import api.Board;
import api.BoardActions;
import api.RetrofitBuilder;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

//TODO create custom asserts instead of several asserts in test
public class BoardTests {

    private BoardActions api;
    private String boardId;
    private final String BOARD_NAME = "Test board";
    private final String UPDATED_BOARD_NAME = "Updated test board";
    private Board keyAndToken;

    @Test(priority = 1, description = "Check user can create a new board")
    public void createBoardTest() throws IOException {
        Board board = new Board();
        board.setName(BOARD_NAME);
        Board createdBoard = api.createNewBoard(board);
        boardId = createdBoard.getId();
        Assert.assertEquals(createdBoard.getName(), BOARD_NAME);
        Assert.assertNotEquals(createdBoard.getId(), null);
        Assert.assertFalse(createdBoard.isClosed());
    }

    @Test(priority = 2, description = "Check user can update a board")
    public void updateBoardTest() throws IOException {
        Board board = new Board();
        board.setName(UPDATED_BOARD_NAME);
        board.setId(boardId);
        Board updatedBoard = api.updateBoardById(board);
        Assert.assertEquals(updatedBoard.getName(), UPDATED_BOARD_NAME);
    }

    @Test(priority = 3, description = "Check user can request for existed board")
    public void checkBoardExists() throws IOException {
        Board board = api.requestBoardById(boardId, keyAndToken.getKey(),
                keyAndToken.getToken());
        Assert.assertEquals(board.getName(), UPDATED_BOARD_NAME);
    }

    @Test(priority = 4, description = "Check user can delete a board")
    public void removeBoard() throws IOException {
        Board board = api.removeBoardById(boardId, keyAndToken.getKey(),
                keyAndToken.getToken());
        Assert.assertNull(board.getName());

    }

    @BeforeClass
    private void beforeAll() {
        api = new BoardActions(new RetrofitBuilder());
        keyAndToken = new Board();
    }
}
