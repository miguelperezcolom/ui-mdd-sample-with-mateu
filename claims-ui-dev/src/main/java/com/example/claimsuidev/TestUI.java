package com.example.claimsuidev;

import com.example.claimsui.ClaimsMenu;
import io.mateu.mdd.core.annotations.MateuUI;
import io.mateu.mdd.shared.annotations.FullWidth;
import io.mateu.mdd.shared.annotations.Submenu;
import io.mateu.security.Private;

@MateuUI(path = "")
public class TestUI {

    @Submenu
    ClaimsMenu claims;

}
