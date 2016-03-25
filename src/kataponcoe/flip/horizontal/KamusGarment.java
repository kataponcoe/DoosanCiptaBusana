package kataponcoe.flip.horizontal;

import java.util.ArrayList;
import java.util.List;

/*
Copyright 2015 Dreamcode Developer

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
 
   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

 */
public class KamusGarment {

  public static final List<Data> IMG_DESCRIPTIONS = new ArrayList<Data>();

  static {
    KamusGarment.IMG_DESCRIPTIONS.add(new KamusGarment.Data("welcomepage.jpg"));
    KamusGarment.IMG_DESCRIPTIONS.add(new KamusGarment.Data("tidaktersedia.jpg"));
    KamusGarment.IMG_DESCRIPTIONS.add(new KamusGarment.Data("splashscreen.png"));
  }

  public static final class Data {

    public final String imageFilename;

    private Data(String imageFilename) {
      this.imageFilename = imageFilename;
    }
  }
}
