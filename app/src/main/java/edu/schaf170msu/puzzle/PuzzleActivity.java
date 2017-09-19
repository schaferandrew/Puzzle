package edu.schaf170msu.puzzle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class PuzzleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_puzzle);

        if(bundle != null) {
            // We have saved state
            getPuzzleView().loadInstanceState(bundle);
        }
    }


    /**
     * Save the instance state into a bundle
     * @param bundle the bundle to save into
     */
    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);

        getPuzzleView().saveInstanceState(bundle);
    }

    /**
     * Get the puzzle view
     * @return PuzzleView reference
     */
    private PuzzleView getPuzzleView() {
        return (PuzzleView)this.findViewById(R.id.puzzleView);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_puzzle, menu);
        return true;    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_shuffle:
                getPuzzleView().getPuzzle().shuffle();
                getPuzzleView().invalidate();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
