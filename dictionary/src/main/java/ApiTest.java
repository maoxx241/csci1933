/*
 * Copyright (c) 2012, IDM
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted
 * provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright notice, this list of
 *       conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright notice, this list
 *       of conditions and the following disclaimer in the documentation and/or other materials
 *       provided with the distribution.
 *     * Neither the name of the IDM nor the names of its contributors may be used to endorse or
 *       promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.json.JSONArray;
import org.json.JSONObject;

import fr.idm.sk.publish.api.client.light.SkPublishAPI;

public class ApiTest {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("need baseurl and accesskey in parameters");
            return;
        }

        DefaultHttpClient httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager());
        SkPublishAPI api = new SkPublishAPI(args[0] + "/api/v1", args[1], httpClient);
        api.setRequestHandler(new SkPublishAPI.RequestHandler() {
            public void prepareGetRequest(HttpGet request) {
                System.out.println(request.getURI());
                request.setHeader("Accept", "application/json");
            }
        });

        try {
            System.out.println("*** Dictionaries");
            JSONArray dictionaries = new JSONArray(api.getDictionaries());
            System.out.println(dictionaries);

            JSONObject dict = dictionaries.getJSONObject(0);
            System.out.println(dict);
            String dictCode = dict.getString("dictionaryCode");

            System.out.println("*** Search");
            System.out.println("*** Result list");
            JSONObject results = new JSONObject(api.search(dictCode, "ca", 1, 1));
            System.out.println(results);
            System.out.println("*** Spell checking");
            JSONObject spellResults = new JSONObject(api.didYouMean(dictCode, "dorg", 3));
            System.out.println(spellResults);
            System.out.println("*** Best matching");
            JSONObject bestMatch = new JSONObject(api.searchFirst(dictCode, "ca", "html"));
            System.out.println(bestMatch);

            System.out.println("*** Nearby Entries");
            JSONObject nearbyEntries = new JSONObject(api.getNearbyEntries(dictCode,
                    bestMatch.getString("entryId"), 3));
            System.out.println(nearbyEntries);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
