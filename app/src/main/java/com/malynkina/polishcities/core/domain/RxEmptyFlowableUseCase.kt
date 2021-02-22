package com.malynkina.polishcities.core.domain

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.ResourceSubscriber

abstract class RxEmptyFlowableUseCase<Result> {
    private var disposable: Disposable? = null

    abstract fun buildFlowable(): Flowable<Result>

    operator fun invoke(
        onComplete: (() -> Unit)? = null,
        onNext: ((Result) -> Unit)? = null,
        onError: ((Throwable) -> Unit)? = null
    ) {
        cancel()
        val observer = object : ResourceSubscriber<Result>() {

            override fun onComplete() {
                onComplete?.invoke()
            }

            override fun onNext(t: Result) {
                onNext?.invoke(t)
            }

            override fun onError(throwable: Throwable) {
                onError?.invoke(throwable)
            }
        }
        this.disposable = observer
        return buildFlowable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)
    }

    fun cancel() {
        disposable?.run {
            if (!isDisposed) dispose()
        }
    }

}

