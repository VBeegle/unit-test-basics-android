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

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * Unit tests for the EmailValidator logic.
 */
public class EmailValidatorTest {


    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {

        boolean result = EmailValidator.isValidEmail("name@email.com");
        assertTrue(result);
        //Another example
        assertTrue(EmailValidator.isValidEmail("my@dot.biz"));
    }

    @Test
    public void emailValidator_IncorrectEmailSimple_ReturnFalse(){
        assertFalse(EmailValidator.isValidEmail("brian@!.com"));
    }

    //This fails because the email validator is not very sophisticated
    @Test
    public void emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"));
    }


    //TODO: Find more VALID emails where the validator fails work

    @Test
    public void emailValidator_CorrectEmailTopDomain_ReturnTrue(){
        assertTrue(EmailValidator.isValidEmail("support@wish.sg"));
    }
    @Test
    public void emailValidator_CorrectEmailName_ReturnTrue(){
        assertTrue(EmailValidator.isValidEmail("y@zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz.com"));
    }

    @Test
    public void emailValidator_CorrectEmailDomain_ReturnTrue(){
        assertTrue(EmailValidator.isValidEmail("abc@[123.123.123.123]"));
    }

    @Test
    public void emailValidator_IncorrectEmailName_ReturnFalse(){
        assertFalse(EmailValidator.isValidEmail("abc.@mail.com"));
    }

    @Test
    public void emailValidator_INcorrectEmailName_ReturnFalse(){
        assertFalse(EmailValidator.isValidEmail(".abc@email.com"));
    }

    @Test
    public void emailValidator_IncorrectEmailDomain_ReturnFalse(){
        assertFalse(EmailValidator.isValidEmail("abc@mail.c-"));
    }

    @Test
    public void emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email"));
    }

    @Test
    public void emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"));
    }

    @Test
    public void emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@email.com"));
    }

    @Test
    public void emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""));
    }

    @Test
    public void emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null));
    }
}
