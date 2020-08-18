package api;

import java.io.IOException;

public class BoardActions {
    private TrelloAPI trelloAPI;

    public BoardActions(final RetrofitBuilder retrofitBuilder) {
        trelloAPI = retrofitBuilder.call();
    }

    public Board createNewBoard(Board board) throws IOException {
        return trelloAPI.createBoard(board).execute().body();
    }

    public Board updateBoardById(Board board) throws IOException {
        return trelloAPI.updateBoard(board, board.getId()).execute().body();
    }

    public Board requestBoardById(String id, String key, String token) throws IOException {
        return trelloAPI.requestBoard(id, key, token).execute().body();
    }

    public Board removeBoardById(String id, String key, String token) throws IOException {
        return trelloAPI.removeBoard(id, key, token).execute().body();
    }
}
