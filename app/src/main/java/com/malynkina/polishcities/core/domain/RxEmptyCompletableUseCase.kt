package com.malynkina.polishcities.core.domain

import io.reactivex.Completable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.schedulers.Schedulers

abstract class RxEmptyCompletableUseCase {
    private var disposable: Disposable? = null

    abstract fun buildCompletable(): Completable

    operator fun invoke(
        onComplete: (() -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null
    ) {
        val observer = object : DisposableCompletableObserver() {

            override fun onComplete() {
                onComplete?.invoke()
            }

            override fun onError(throwable: Throwable) {
                onError?.invoke(throwable)
            }
        }
        this.disposable = observer
        return buildCompletable()
                .subscribeOn(Schedulers.io())
                .subscribe(observer)
    }

    fun cancel() {
        disposable?.run {
            if (!isDisposed) dispose()
        }
    }
}
