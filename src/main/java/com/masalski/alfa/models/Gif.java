package com.masalski.alfa.models;

public class Gif {
    private final Data data;
    private final Meta meta;

    public Gif(Data data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }

    public Data getData() {
        return data;
    }

    public Meta getMeta() {
        return meta;
    }

    @Override
    public String toString() {
        return "Gif{" +
                "data=" + data +
                ", meta=" + meta +
                '}';
    }

    public static class Data {
        private final String url;
        private final String embed_url;
        private final String title;
        private final String rating;
        private final Images images;


        public Data(String url, String embed_url, String title, String rating, Images images) {
            this.url = url;
            this.embed_url = embed_url;
            this.title = title;
            this.rating = rating;
            this.images = images;
        }

        public String getUrl() {
            return url;
        }

        public String getEmbed_url() {
            return embed_url;
        }

        public String getTitle() {
            return title;
        }

        public String getRating() {
            return rating;
        }

        public Images getImages() {
            return images;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "url='" + url + '\'' +
                    ", embed_url='" + embed_url + '\'' +
                    ", title='" + title + '\'' +
                    ", rating='" + rating + '\'' +
                    ", images=" + images +
                    '}';
        }
    }

    public static class Meta {
        private final String msg;
        private final String status;
        private final String response_id;

        public Meta(String msg, String status, String response_id) {
            this.msg = msg;
            this.status = status;
            this.response_id = response_id;
        }

        public String getMsg() {
            return msg;
        }

        public String getStatus() {
            return status;
        }

        public String getResponse_id() {
            return response_id;
        }

        @Override
        public String toString() {
            return "Meta{" +
                    "msg='" + msg + '\'' +
                    ", status='" + status + '\'' +
                    ", response_id='" + response_id + '\'' +
                    '}';
        }
    }

    public static class Images {

        private final DownsizedLarge downsized_large;

        private final Hd hd;

        public Images(DownsizedLarge downsized_large, Hd hd) {
            this.downsized_large = downsized_large;
            this.hd = hd;
        }

        public Hd getHd() {
            return hd;
        }

        public DownsizedLarge getDownsized_large() {
            return downsized_large;
        }

        @Override
        public String toString() {
            return "Images{" +
                    "downsized_large=" + downsized_large +
                    ", hd=" + hd +
                    '}';
        }

        public static class Hd {
            private final String height;
            private final String mp4;
            private final String mp4_size;
            private final String width;

            public Hd(String height, String mp4, String mp4_size, String width) {
                this.height = height;
                this.mp4 = mp4;
                this.mp4_size = mp4_size;
                this.width = width;
            }

            public String getHeight() {
                return height;
            }

            public String getMp4() {
                return mp4;
            }

            public String getMp4_size() {
                return mp4_size;
            }

            public String getWidth() {
                return width;
            }

            @Override
            public String toString() {
                return "Hd{" +
                        "height='" + height + '\'' +
                        ", mp4='" + mp4 + '\'' +
                        ", mp4_size='" + mp4_size + '\'' +
                        ", width='" + width + '\'' +
                        '}';
            }
        }

        public static class DownsizedLarge {
            private final String height;
            private final String size;
            private final String url;
            private final String width;

            public DownsizedLarge(String height, String size, String url, String width) {
                this.height = height;
                this.size = size;
                this.url = url;
                this.width = width;
            }

            public String getHeight() {
                return height;
            }

            public String getSize() {
                return size;
            }

            public String getWidth() {
                return width;
            }

            public String getUrl() {
                return url;
            }

            @Override
            public String toString() {
                return "DownsizedLarge{" +
                        "height='" + height + '\'' +
                        ", size='" + size + '\'' +
                        ", url='" + url + '\'' +
                        ", width='" + width + '\'' +
                        '}';
            }
        }
    }
}
