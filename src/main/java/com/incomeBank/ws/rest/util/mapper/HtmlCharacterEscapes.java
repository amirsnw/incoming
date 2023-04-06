package com.incomeBank.ws.rest.util.mapper;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.core.io.CharacterEscapes;

/**
 *
 * @see <a href="http://www.cowtowncoder.com/blog/archives/2012/08/entry_476.html">http://www.cowtowncoder.com/blog/archives/2012/08/entry_476.html</a>
 */
public class HtmlCharacterEscapes extends CharacterEscapes {

    private final int[] asciiEscapes;

    public HtmlCharacterEscapes() {
        // start with set of characters known to require escaping (double-quote, backslash etc)
        int[] esc = CharacterEscapes.standardAsciiEscapesForJSON();
        // and force escaping of a few others:
        esc['<'] = CharacterEscapes.ESCAPE_STANDARD;
        esc['>'] = CharacterEscapes.ESCAPE_STANDARD;
        esc['&'] = CharacterEscapes.ESCAPE_STANDARD;
        esc['\''] = CharacterEscapes.ESCAPE_STANDARD;
        asciiEscapes = esc;
    }

    // this method gets called for character codes 0 - 127
    @Override
    public int[] getEscapeCodesForAscii() {
        return asciiEscapes;
    }

    // and this for others; we don't need anything special here
    @Override
    public SerializableString getEscapeSequence(int ch) {
        // no further escaping (beyond ASCII chars) needed:
        return null;
    }
}

