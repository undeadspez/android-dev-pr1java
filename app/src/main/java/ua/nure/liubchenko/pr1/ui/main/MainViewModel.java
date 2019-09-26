package ua.nure.liubchenko.pr1.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import android.graphics.Color;
import ua.nure.liubchenko.pr1.utils.ColorUtils;

public class MainViewModel extends ViewModel {

    private static int defaultColor = Color.parseColor("#ffa500");

    private MutableLiveData<Integer> redComponent =
        new MutableLiveData<>(Color.red(defaultColor));

    private MutableLiveData<Integer> greenComponent =
        new MutableLiveData<>(Color.green(defaultColor));

    private MutableLiveData<Integer> blueComponent =
        new MutableLiveData<>(Color.blue(defaultColor));

    private LiveData<Integer> color =
        Transformations.switchMap(redComponent, r ->
            Transformations.switchMap(greenComponent, g ->
                Transformations.switchMap(blueComponent, b ->
                    new MutableLiveData<>(
                        ColorUtils.composeColor(0xff, r, g, b)
                    )
                )
            )
        );

    private LiveData<Integer> textColor =
        Transformations.map(color, c -> (Color.luminance(c) > 0.5) ? Color.BLACK : Color.WHITE);

    private LiveData<String> colorLabel =
        Transformations.map(color, c -> String.format("#%06x", 0xFFFFFF & c));

    public LiveData<Integer> getTextColor() {
        return textColor;
    }

    public LiveData<Integer> getColor() {
        return color;
    }

    public LiveData<String> getColorLabel() {
        return colorLabel;
    }

    public MutableLiveData<Integer> getRedComponent() {
        return redComponent;
    }

    public MutableLiveData<Integer> getGreenComponent() {
        return greenComponent;
    }

    public MutableLiveData<Integer> getBlueComponent() {
        return blueComponent;
    }

}
