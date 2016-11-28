package com.it5.swiprefreshmore.demo.tips;

/**
 * Created by IT5 on 2016/11/25.
 */

public interface TipsHelper {
    void showEmpty();

    void hideEmpty();

    void showLoading(boolean firstPage);

    void hideLoading();

    void showError(boolean firstPage, Throwable error);

    void hideError();

    void showHasMore();

    void hideHasMore();

}
