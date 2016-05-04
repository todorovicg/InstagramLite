package eu.execom.instagramlite.fragments;

import android.support.v4.app.Fragment;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import eu.execom.instagramlite.R;
import eu.execom.instagramlite.adapters.MyPicturesGridAdapter;
import eu.execom.instagramlite.models.User;
import eu.execom.instagramlite.repository.UserRepository;

/**
 * User that handles profile data
 */
@EFragment(R.layout.fragment_user_profile)
public class UserProfileFragment extends Fragment {

    @Bean
    UserRepository userRepository;

    @ViewById
    ImageView profileImage;

    @ViewById
    TextView name;

    @Bean
    MyPicturesGridAdapter myPicturesGridAdapter;

    @ViewById
    GridView picturesGrid;

    @AfterViews
    void afterViews() {
        final User user = userRepository.getUser();
//        profileImage.setImageResource(user.getImageResId());
        name.setText(user.getUsername());
        picturesGrid.setAdapter(myPicturesGridAdapter);
    }

}
