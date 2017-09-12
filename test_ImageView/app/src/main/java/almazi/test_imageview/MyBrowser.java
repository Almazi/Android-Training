package almazi.test_imageview;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by almazi on 9/7/17.
 */

class MyBrowser extends WebViewClient {
    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
