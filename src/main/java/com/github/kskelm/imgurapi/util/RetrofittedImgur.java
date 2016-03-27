/**
 * Retrofit implementation of the Imgur 3 API
 */
package com.github.kskelm.imgurapi.util;

import java.util.List;

import com.github.kskelm.imgurapi.model.Account;
import com.github.kskelm.imgurapi.model.AccountSettings;
import com.github.kskelm.imgurapi.model.GalleryItem;
import com.github.kskelm.imgurapi.model.GalleryItemProxy;
import com.github.kskelm.imgurapi.model.Image;
import com.github.kskelm.imgurapi.model.ImgurResponseWrapper;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * @author kskelm
 *
 */
public interface RetrofittedImgur {


	// ============================================================
	// ACCOUNT CALLS
	// ============================================================

	@GET("/3/account/{username}")
	Call<ImgurResponseWrapper<Account>> getAccount(
			@Path("username") String userName );
	
	@GET("/3/account/{username}/settings")
	Call<ImgurResponseWrapper<AccountSettings>> getAccountSettings(
			@Path("username") String userName );

	@GET("/3/account/{username}/gallery_favorites/{page}/{sort}")
	Call<ImgurResponseWrapper<List<GalleryItem>>> getAccountGalleryFavorites(
			@Path("username") String userName,
			@Path("page") int page,
			@Path("sort") Account.GallerySort sort );


	// ============================================================
	// IMAGE CALLS
	// ============================================================

	@GET("/3/image/{id}")
	Call<ImgurResponseWrapper<Image>> getImageInfo(
			@Path("id") String id );

	
	// ============================================================
	// GALLERY CALLS
	// ============================================================
	@GET("/3/gallery/{section}/{sort}/{window}/{page}?showViral={viral}")
	Call<List<GalleryItemProxy>> getGallery(
			@Query("page") int page,
			@Query("section") GalleryItem.Section section,
			@Query("sort") GalleryItem.Sort sort,
			@Query("window") GalleryItem.Window window,
			@Query("viral") boolean viral
			);	

	@GET("/3/gallery/{section}/{sort}/{page}.json")
	Call<ImgurResponseWrapper<List<GalleryItemProxy>>> getGallery(
			@Path("section") String section,
			@Path("sort") String sort,
			@Path("page") int page );	

} // interface RetrofittedImgur
