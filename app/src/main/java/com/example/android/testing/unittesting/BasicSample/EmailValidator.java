/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.testing.unittesting.BasicSample;

import android.text.Editable;
import android.text.TextWatcher;

import java.util.regex.Pattern;

/**
 * An Email format validator for {@link android.widget.EditText}.
 */
public class EmailValidator implements TextWatcher {

    /**
     * Unsophisticated e-mail validation pattern.
     * TODO: Find a better Regular Expression email pattern online
     */
    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"
    );

    private boolean mIsValid = false;

    public boolean isValid() {
        return mIsValid;
    }

    /**
     * Validates if the given input is a valid email address.
     *
     * @param email        The email to validate.
     * @return {@code true} if the input is a valid email. {@code false} otherwise.
     */
    public static boolean isValidEmail(CharSequence email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    @Override
    final public void afterTextChanged(Editable editableText) {
        mIsValid = isValidEmail(editableText);
    }

    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) {/*No-op*/}

    @Override
    final public void onTextChanged(CharSequence s, int start, int before, int count) {/*No-op*/}
}
