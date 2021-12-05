package com.spx.composedy

import android.util.Log
import androidx.lifecycle.ViewModel

class ComposeDyViewModel : ViewModel() {

  fun getVideoUrl(index: Int): String {
    Log.i(TAG, "getVideoUrl: $index")
    if(index>=videoUrls.size){
      return ""
    }
    return videoUrls[index]
  }

  private val TAG: String = "ComposeDyViewModel"
  val videoUrls = arrayOf("http://txmov6.a.kwimgs.com/upic/2021/11/24/14/BMjAyMTExMjQxNDMwNDhfNzQzMDI3NTA0XzYxNDUwNDM3NDE1XzJfMw==_b_B9c1aebd8878600e07a8225a82baf33c7.mp4?tag=1-1638269558-n-0-5967be10b83044ab-3d4b358efb604372&clientCacheKey=3x6vnsys5u8viju_b.mp4&tt=b&di=b44c958d&bp=10531",
    "http://txmov6.a.yximgs.com/ksc1/E97F0hZVoKHOMHAYKHy-wObgSQZzDr0rEAELwqQyWpCylZ2yAbtmqag4-iDcpkUN6F4Z0HxRWKpIgRt5r3gXE_AyK0AyGQGdw9be4cmDkh28vx33Cz30qh5JXpPoZu5Gc-GBGXmZ_D2mlhA9J_01eLYyjHmVjmM8HU5xzDML31Pae4ooj42yGopUhECu2ljD.mp4?tag=1-1638269554-h-0-ows6cujhss-a4df9064d4640605&clientCacheKey=3xjuhiw24tqap2a_b.mp4&tt=b&di=b44c958d&bp=10251",
    "http://txmov6.a.yximgs.com/ksc1/MnGQs_16aR9OgiLHaKsWDLGch6pZW7I-ZqlVC5mwBwoOkCAoTmSQpfnuWQevXzY3g5OuNmFdntQlSGYVLtIUZUrIlNk4oWuu2vaW0Iw7WpBEBbNluWH1jrLQCCi0wSAF0XoKyHxN8N0LkCswtX4R0wgmCrsvUQaFZA4QT-sgNYahvd-U_9aFI7bwfOY3rXkV.mp4?tag=1-1638269079-n-0-5967be10b83044ab-3d4b358efb604372&clientCacheKey=3xnz7exfguyeisa_b.mp4&tt=b&di=b44c958d&bp=10531",
  "http://txmov6.a.yximgs.com/ksc1/8Zmnjrn08JREmqKUZNxfUt3AQMPTMbNNZoirE4SPqJIyoeklr8ORKIxwMCOXtYeGtZW3XOFNenfLarW4qYe0s_fhSmK-LdP1M4aXO7erFc3pkpbfpwhbmmRxioChxp6n2SY0BW7SsdnP5W5OON4izJFWCEcNzNYMPCDI6NStFk44M1lB-42HYi5XZ0BU0VsN.mp4?tag=1-1638268954-h-0-jnl0o5zgbp-e95cd0f6981255dd&type=hot&clientCacheKey=3xk2jpag5a7yk7s_b.mp4&tt=b&di=b44c958d&bp=10251",
  "http://txmov6.a.yximgs.com/ksc1/rhTK46BxVz5v9njGXDjZzDyee9tBJdwnKXtVnawYnthl5bI_5A5xn7jPqxzxbwceqhhcL_HWesTetgX8eZj9z2wMuKZHWOg9349NuQ5wJJPZWZCsgAbIUAD1sd-YQY0NCfsB5JzPPWeIY2pQ5xZrz-yzPRCt4kVxotXij-bw0aQEH7e6Rc6hcTpeKtCGpUDQ.mp4?tag=1-1638268954-h-0-yhmjyne2z3-62dd740cbd94a3e3&type=hot&clientCacheKey=3xawgyth4v7367w_b.mp4&tt=b&di=b44c958d&bp=10251",
  "http://txmov6.a.kwimgs.com/upic/2021/11/21/19/BMjAyMTExMjExOTAxMTNfMjU1Njc3MzcxN182MTI5ODcyNDQ2M18yXzM=_b_B5623197788cabd178438de0ac8933424.mp4?tag=1-1638268714-h-0-gxfwnxjt1a-26c9ad679820f66b&clientCacheKey=3xqvzz8j29nzvaq_b.mp4&tt=b&di=b44c958d&bp=10251",
  "http://txmov6.a.yximgs.com/ksc1/QzEqIQr3AaS9lamML9CCzYPeLIHnpVf-HYPEfJ0V7ueo_5NnQFQQonULuFord7qEtSTDtbN1OqpWi0RwRd61Y_Lqi0ase3zaHmqBjHLk3I-KK_rFNi9ZgqWmzKdNuJEv4y0Q5EzIXjTzfe1bp6WB_b_8WSr_QQ-wJwEx4nHpSWJyiJj2WQXEZM4udgGzMvQA.mp4?tag=1-1638268590-bs-0-efrjppch3r-2d9281d22a8941a3&type=hot&clientCacheKey=3xqiz4m3d8hd4b2_b.mp4&tt=b&di=b44c958d&bp=10331",
  "http://txmov6.a.kwimgs.com/upic/2021/11/30/06/BMjAyMTExMzAwNjEyMTZfMTYxNjcyNDA2Ml82MTgwMTY0OTQ3Nl8xXzM=_b_B859aaffb1a1ba94a0c27e58600df0ac6.mp4?tag=1-1638268123-hc-0-5967be10b83044ab-3d4b358efb604372&clientCacheKey=3x2fismqc83td3m_b.mp4&tt=b&di=b44c958d&bp=10221")
}