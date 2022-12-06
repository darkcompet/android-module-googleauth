/*
 * Copyright (c) 2017-2020 DarkCompet. All rights reserved.
 */
package tool.compet.googleauth

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

/**
 * Provide auth (login, logout,...) with Google service.
 * By default, this request email for login.
 */
class DkGoogleAuthClient(context: Context, serverClientId: String) {
	private val googleSignInClient: GoogleSignInClient

	init {
		val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
			.requestIdToken(serverClientId)
			.requestEmail()
			.build()

		googleSignInClient = GoogleSignIn.getClient(context, options)
	}

	val intentForLogin
		get() = googleSignInClient.signInIntent

	fun getLastSignedInAccount(context: Context): GoogleSignInAccount? {
		return GoogleSignIn.getLastSignedInAccount(context)
	}

	fun logout() {
		googleSignInClient.signOut()
	}
}